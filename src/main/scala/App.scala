package com.opyate

import unfiltered.request._
import unfiltered.response._

/** unfiltered plan */
class App extends unfiltered.filter.Plan {
  import QParams._

  def intent = {
    case GET(Path("/")) =>
      Ok ~> view(Map.empty)(<p> How many nodes? </p>)
    case POST(Path(p) & Params(params)) =>

      val vw = view(params)_
      val expected = for {
        int <- lookup("int") is
          int { _ + " is not an integer" } is
          required("missing int")
      } yield vw(<p>Creating { int.get } nodes. </p>)
      expected(params) orFail { fails =>
        vw(<ul class="fail"> { fails.map { f => <li>{f.error} </li> } } </ul>)
      }
  }

  def view(params: Map[String, Seq[String]])(body: scala.xml.NodeSeq) = {
    def p(k: String) = params.get(k).flatMap { _.headOption } getOrElse("")
    Html(
     <html>
      <head>
        <link rel="stylesheet" type="text/css" href="/css/app.css" />
        <script type="text/javascript" src="/js/app.js"></script>
      </head>
      <body>
        <div id="container">
          <hr/>
          { body }
           <form method="POST">
             Nodes <input name="int" value={ p("int") } ></input>
             <input type="submit" />
           </form>
          </div>
        </body>
      </html>
   )
  }
}
