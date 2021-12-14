package spark_wc

import org.apache.spark.{SparkConf, SparkContext}

object Spark02_WordCount {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local").setAppName("wordCount")
    val sc = new SparkContext(sparkConf)

    val lines = sc.textFile("datas")
    val words = lines.flatMap(_.split(" "))
    val wordToOne = words.map(
      word => {
        (word, 1)
    })
    val wordGroup = wordToOne.groupBy(_._1)
    val wordToCount = wordGroup.map {
      case (word, list) => {
        //前后两个进行reduce
        list.reduce(
          //t1,t2是前后两个元素
          (t1, t2) => {
            (t1._1, t1._2 + t2._2)
          }
        )
      }
    }

    wordToCount.foreach(println)

  }

}
