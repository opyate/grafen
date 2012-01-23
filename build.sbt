seq(sbtappengine.Plugin.webSettings:  _*)

resolvers ++= Seq(
 "jboss" at  "https://repository.jboss.org/nexus/content/groups/public/"
  // app engine repo, uncomment the following line for persistence resolver
  //, "nexus" at "http://maven-gae-plugin.googlecode.com/svn/repository/"
)

seq(lsSettings :_*)

