fun main(args: Array<String>){
    val book = book("C/C++", "Louis", 1998)

    val bookTitleAuthor = book.getTitleAuthor()
    println("Here is your book ${bookTitleAuthor.first} by ${bookTitleAuthor.second}")

    val bookTitleAuthorYear = book.getTitleAuthorYear()
    println("Here is your book ${bookTitleAuthorYear.first} by ${bookTitleAuthorYear.second} written in ${bookTitleAuthorYear.third} ")

    val (title, author, year) = book.getTitleAuthorYear()
    println("Here is your book $title written by $author in $year")
}

class book(val title : String, val author : String, val year: Int){

    fun getTitleAuthor() : Pair<String, String> {
        return title to author
    }

    fun getTitleAuthorYear() : Triple<String, String, Int> {
        return Triple(title, author, year)
    }
}