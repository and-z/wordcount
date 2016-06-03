package wordcount

import java.io.File

fun countWordsInFile(filePath: String): Map<String, Int> {
  val file = File(filePath)
  return file.useLines(Charsets.UTF_8, ::countWordsInLines)

/*
  while ((line = br.readLine()) != null) {
    val words = line.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    for (i in words.indices) {
      val word = words[i]
      if (counts.get(word) == null) {
        counts.put(word, 1)
      } else {
        counts.put(word, counts.get(word).toInt() + 1)
      }
    }
  }
*/
}

private fun countWordsInLines(seq: Sequence<String>): Map<String, Int> {
  return wordSeq(seq).groupBy { it -> it }.mapValues { it.value.size }
}

private fun wordSeq(seq: Sequence<String>): Sequence<String> = seq.flatMap { it.split(" ".toRegex()).asSequence() }