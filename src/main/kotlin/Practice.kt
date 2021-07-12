import java.util.*


   fun main(args: Array<String>)
    {
        var cookie: String
        /*for(i in 1..10) {
            cookie = getFortuneCookie(getBirthday())
            print("\nYour fortune is: $cookie")
            if (cookie.contains("Take it easy")) break;
        }*/

        cookie = ""
        while (!cookie.contains("Take it easy")) {
            cookie = getFortuneCookie(getBirthday())
            println("\nYour fortune is: $cookie")
        }

    }

    fun getFortuneCookie(birthday : Int) : String {
        val fortuneList = listOf(
            "You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune."
        )
        val index = when (birthday) {
            28, 31 -> 0
            in 1..7 -> 1
            else -> birthday.rem(fortuneList.size)
        }
        return fortuneList[index]
    }

    fun getBirthday() : Int {
        print("\nEnter your birthday")
        // readline doesn't work so random is used instead
        //return readline()?.toIntOrNull() ?: 1
        return Random().nextInt(31)
    }

