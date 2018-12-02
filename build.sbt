name := "sample_scala_project"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= {

  Seq(
    "io.argonaut"            %% "argonaut"          % "6.2.2",
    "io.argonaut"            %% "argonaut-monocle"  % "6.2.2"    % Test,
    "org.scalatest"          %% "scalatest"         % "3.0.5"    % Test,
    "org.scalacheck"         %% "scalacheck"        % "1.14.0"   % Test,
  )
}