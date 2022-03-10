package groovylab

class App {
    static void main(String[] args) {
        Task01.sum(1,4) == 5 ? println ("task01 done") : println ("task01 FAIL")
        Task02.mulEvenOdd([4,5,6]) == [8,15,12] ? println ("task02 done") : println ("task02 FAIL")
        Task03.isSublist([1,2,3], [2,3]) == true ? println ("task03 done") : println ("task03 FAIL")
        Task04.fib(4) == 3 ? println ("task04 done") : println ("task04 FAIL")
        Task05.isIp("10.0.152.164") == true ? println ("task05 done") : println ("task05 FAIL")
        Task06.adults([Kate: 24, Alan:16, Osvald: 18]) == [Kate: 24, Osvald: 18] ? println ("task06 done") : println ("task06 FAIL")
        Task07.encryptThis("Hello") == "72olle" ? println ("task07 done") : println ("task07 FAIL")
        Task08.parseAndFilterJson("{\"Kate\":18,\"Alan\":16,\"Osvald\":27}") == "{\"Kate\":18,\"Osvald\":27}" ? println ("task08 done") : println ("task08 FAIL")
        Task09.exec("date") == "date".execute().text.trim() ? println ("task09 done") : println ("task09 FAIL")
        Task10.urlText("http://httpstat.us/200") == "200 OK" ? println ("task10 done") : println ("task10 FAIL")
        Task11.gstring("test", 2) == "1() 2(test) 3()" ? println ("task11 done") : println ("task11 FAIL")
        TaskCalculator.exec("1+9/3") == 4 ? println ("test calc #2 done") : println ("test calc #2 FAIL")
        TaskCalculator.exec("6(3+1)") == 24 ? println ("test calc #1 done") : println ("test calc #1 FAIL")
    }
}
