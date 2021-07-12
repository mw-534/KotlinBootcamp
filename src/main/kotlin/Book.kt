const val MAX_NUMBER_TO_BORROW = 5

object Constants {
    const val URL = "http://www.turtlecare.net/"
}

open class Book(val title: String, val author: String, var pages: Int = 0) {

    private var currentPage = 1

    open fun readPage() {
        currentPage++
    }

    fun canBorrow(borrowedBooks : Int) : Boolean {
        return borrowedBooks <= MAX_NUMBER_TO_BORROW
    }

    companion object {
        const val BASE_URL = "library-url/"
    }

    fun printUrl() = "$BASE_URL$title.html"

}

class eBook(title: String, author: String, var format: String = "text") : Book(title, author) {

    private var wordsRead = 0

    override fun readPage() {
        wordsRead += 250
    }
}

fun Book.weight() : Double {
    return (pages * 1.5)
}

fun Book.tornPages(torn: Int) = if (pages >= torn) pages -= torn else 0

class Puppy() {
    fun playWithBook(book: Book) {
        book.tornPages(java.util.Random().nextInt(book.pages))
    }
}

fun puppyPlaysWithBook() {
    val book = Book("Romeo and Juliet", "shakespeare", 200 )
    val puppy = Puppy()
    while (book.pages > 0) {
        puppy.playWithBook(book)
        println("${book.pages} left in ${book.title}")
    }
    println("Sad puppy, no more pages left in ${book.title}.")
}