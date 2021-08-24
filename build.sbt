name := "LagomBasicDemo"

version := "0.1"

scalaVersion := "2.13.6"


val macwire = "com.softwaremill.macwire" %% "macros" % "2.3.3" % "provided"
val scalaTest = "org.scalatest" %% "scalatest" % "3.1.1" % Test

lazy val `LagomService` = (project in file("."))
  .aggregate(`HelloService-api`, `HelloService-impl` )

lazy val `HelloService-api` = (project in file("HelloService-api"))
  .settings(
    ThisBuild / lagomKafkaEnabled := false,
    ThisBuild / lagomCassandraEnabled := false,
    libraryDependencies ++= Seq(
      lagomScaladslApi
    )
  )

lazy val `HelloService-impl` = (project in file("HelloService-impl"))
  .enablePlugins(LagomScala)
  .settings(

    ThisBuild / lagomKafkaEnabled := false,
    ThisBuild / lagomCassandraEnabled := false,
    libraryDependencies ++= Seq(
      lagomScaladslPersistenceJdbc,
      lagomScaladslKafkaBroker,
      lagomScaladslAkkaDiscovery,
      lagomScaladslTestKit,
      macwire,
      scalaTest
    )
  )
  .settings(lagomForkedTestSettings)
  .dependsOn(`HelloService-api`)
