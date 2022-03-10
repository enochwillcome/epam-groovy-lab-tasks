/**
Define, whether input string have a Ip format. Example:
Task05.isSublist("10.0.152.164") == true
*/

package groovylab

class Task05 {
    public static boolean isIp(String ip) {
        return ip ==~ /^((25[0-5]|(2[0-4]|1\d|[1-9]|)\d)(\.(?!$)|$)){4}$/ ? true : false
    }
}
