/**
Execute input string as a system command and return output (output must be
trimmed using .trim() function). Example:
Task09.exec("date") == "Mon Dec  3 22:40:34 +03 2018"
*/

package groovylab

class Task09 {
    public static String exec(String command) {
        return command.execute().text.trim()
    }
}
