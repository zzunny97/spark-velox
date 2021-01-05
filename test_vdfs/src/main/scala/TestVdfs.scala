//import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.dicl.velox.mapreduce.LeanInputFormat
import org.apache.hadoop.io.{LongWritable, Text}
//import org.apache.hadoop.mapreduce.lib.input.TextInputFormat

object TestVdfs {
  def main(args: Array[String]) {
    val sc = new SparkContext(new SparkConf().setMaster("yarn").setAppName("vdfstest"))
	val rdd = sc.newAPIHadoopFile[LongWritable, Text, LeanInputFormat]("hdfs://115.145.173.24:9000/small_150k.dat")
	//val rdd = sc.newAPIHadoopFile[LongWritable, Text, TextInputFormat]("hdfs://115.145.173.24:9000/sample.txt")
	val count = rdd.flatMap(line => line._2.toString().split(" ")).map(word => (word, 1)).reduceByKey(_ + _)
	count.saveAsTextFile("file:///home/velox/outfile")
  }
}
