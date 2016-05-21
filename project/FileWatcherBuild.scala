import sbt._
import Keys._

import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform
import SbtScalariform._
import SonatypeSupport._

import de.heikoseeberger.sbtheader.HeaderKey

object FileWatcherBuild extends Build {

  override val settings = super.settings ++ Seq(
    organization := "org.ensime",
    version := "1.0.0",
    scalaVersion := "2.11.8"
  ) ++ sonatype("ensime", "java7-file-watcher", Apache2)

  lazy val root = (project in file(".")).
    settings(Sensible.settings).settings(
      name := "java7-file-watcher",
      javaOptions in Test ++= Seq("-Dlogback.configurationFile=logback-test.xml"),
      HeaderKey.headers in Compile := Copyright.ApacheMap,
      HeaderKey.headers in Test := Copyright.GplMap,
      libraryDependencies ++= Sensible.testLibs() ++
        Sensible.logback ++ Sensible.guava
    )

}
