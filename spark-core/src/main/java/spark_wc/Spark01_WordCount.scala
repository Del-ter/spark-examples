package spark_wc

import org.apache.spark.{SparkConf, SparkContext}

object Spark01_WordCount {
  def main(args: Array[String]): Unit = {

    //application
    //spark框架
    //todo 建立与spark框架的连接
    //jdbc:connection
    val sparkConf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    //todo 执行业务操作
    //1、读取文件，一行一行获取数据
    val lines = sc.textFile("datas")

    //2、将一行数据进行拆分，形成分词效果(扁平化操作)
    val words = lines.flatMap(_.split(" "))

    //3、将数据根据单词进行归纳分组，便于统计
    val wordGroup = words.groupBy(word => word)

    //4、分组后的数据进行转换，计数
    val wordToCount = wordGroup.map { case (word, list) => {
      (word, list.size)
    }
    }

    //5、将转换结果采集到控制台
    val array = wordToCount.collect()
    array.foreach(println)



    //todo 关闭连接
    sc.stop()

  }
}
