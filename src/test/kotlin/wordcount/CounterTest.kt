package wordcount

import org.assertj.core.api.Assertions
import org.assertj.core.data.MapEntry
import org.junit.Test
import java.nio.file.Paths

class CounterTest {

  @Test fun should_count_word_appearance_in_given_file() {
    val expectedEntries = arrayOf(
        MapEntry.entry("one", 1),
        MapEntry.entry("two", 2),
        MapEntry.entry("three", 3),
        MapEntry.entry("x", 1),
        MapEntry.entry("y", 1),
        MapEntry.entry("z", 1))

    val path = Paths.get("src/test/resources/test.txt")
    val result = countWordsInFile(path.toString())

    Assertions.assertThat(result).containsExactly(*expectedEntries)
  }
}