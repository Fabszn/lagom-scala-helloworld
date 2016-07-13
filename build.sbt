import sbt._

name in ThisBuild :="lagom-scala-helloworld"

organization in ThisBuild := "sample.lagom.scala"

// the Scala version that will be used for cross-compiled libraries
scalaVersion in ThisBuild := "2.11.7"



lazy val helloworldApi = (project in file("helloworld-api"))
  .settings(
    version := "1.0-SNAPSHOT",
    libraryDependencies += lagomJavadslApi

  )

lazy val helloworldImpl = (project in file("helloworld-impl"))
  .enablePlugins(LagomJava)
  .settings(
    scalacOptions in Compile += "-Xexperimental", // this enables Scala lambdas to be passed as Java SAMs
    version := "1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      lagomJavadslPersistence,
      lagomJavadslTestKit
    )
  )
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(helloworldApi)

lagomCassandraEnabled in ThisBuild := false

// See https://github.com/FasterXML/jackson-module-parameter-names
lazy val jacksonParameterNamesJavacSettings = Seq(
  javacOptions in compile += "-parameters"
)
