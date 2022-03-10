/**
Perform a HTTP request to the address, specified in function and return text
output. Example:
Task10.urlText("http://httpstat.us/200") == "200 OK"
*/

package groovylab

class Task10 {
    public static String urlText(String url) {
        url.toURL().text
        //return new URL(url).openConnection().getResponseCode() == 200 ? "200 OK" : new URL(url).openConnection().getResponseCode()
    }
}
