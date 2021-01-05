#!/bin/bash
rm -rf ~/outfile
spark-submit --master yarn \
		--deploy-mode client \
		--jars /home/velox/sandbox/lib/java/veloxdfs.jar,/home/velox/.m2/repository/org/dicl/velox/velox-hadoop/1.0/velox-hadoop-1.0.jar \
		--num-executors 3 \
		--executor-cores 16 \
		--class TestVdfs target/scala-2.12/vdfs-test_2.12-0.1.0-SNAPSHOT.jar
