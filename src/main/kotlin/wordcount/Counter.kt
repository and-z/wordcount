package wordcount

import java.io.File

fun countWordsInFile(filePath: String): Map<String, Int> {
  val file = File(filePath)
  return file.useLines(Charsets.UTF_8, ::countWordsInLines)
}

private fun countWordsInLines(seq: Sequence<String>): Map<String, Int> {
  return wordSeq(seq).groupBy { it -> it }.mapValues { it.value.size }
}

private fun wordSeq(seq: Sequence<String>): Sequence<String> = seq.flatMap { it.split(" ".toRegex()).asSequence() }