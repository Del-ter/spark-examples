package spark_wc

import org.apache.spark.{SparkConf, SparkContext}

object Spark03_WordCount {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local").setAppName("wordCount")
    val sc = new SparkContext(sparkConf)

    val lines = sc.textFile("datas")
    val words = lines.flatMap(_.split(" "))
    val wordToOne = words.map((_,1))

    //Spark框架提供了更多的功能，可以将分组和聚合使用一个方法完成
    //reduceByKey：对于相同key的数据，可以对value进行reduce聚合
    val wordToCount = wordToOne.reduceByKey(_ + _)

    wordToCount.foreach(println)

  }

}
