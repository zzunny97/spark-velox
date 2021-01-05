name := "VDFS Test"

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.0.1"
libraryDependencies += "org.dicl.velox" %% "velox-hadoop" % "1.0" from "file:///home/velox/.m2/repository/org/dicl/velox/velox-hadoop/1.0/velox-hadoop-1.0.jar"
libraryDependencies += "org.dicl.velox" %% "veloxdfs" % "1.0" from "file:///home/velox/sandbox/lib/java/veloxdfs.jar"
