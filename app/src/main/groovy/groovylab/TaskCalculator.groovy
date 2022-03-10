/**
Calculate input expression. Example:
TaskCalculator.exec("6(3+1)") == 24
TaskCalculator.exec("1+9/3") == 4
*/

package groovylab

class TaskCalculator {
    private static Number plus(Number left, Number right){
        return (left += right)
    }
    private static Number dev(Number left, Number right){
        return (left /= right)
    }
    private static Number mult(Number left, Number right){
        return (left *= right)
    }
    private static Number minus(Number left, Number right){
        return (left -= right)
    }

    private static Number CalcTwoSide(def left, def operator, def right){
        def output
        if (operator == "*"){
            output = this.mult(left.toInteger(), right.toInteger())
        }else if(operator == "/"){
            output = this.dev(left.toInteger(), right.toInteger())
        }else if(operator == "+"){
            output = this.plus(left.toInteger(), right.toInteger())
        }else if(operator == "-"){
            output = this.minus(left.toInteger(), right.toInteger())
        }
        return output
    }

    public static Number exec(String expression) {
        def output
        def FindBrackets = (expression =~ /\((\d+)([*\/+-])(\d+)\)/)
        if (FindBrackets){
            def (bracket,leftBr,symbolBr,rightBr) = (FindBrackets[0]) 
            def FirstPart = this.CalcTwoSide(leftBr, symbolBr, rightBr)
            def SecondPart = expression.replaceAll(/\((\d+)(?<br>[*\/+-])(\d+)\)/, '' )
            if (SecondPart =~ /(\d+)([+-\/*])/){
                def (all,digit,symbol) = (SecondPart =~ /(\d+)([+-\/*])/)[0]
                output = this.CalcTwoSide(digit, symbol, FirstPart)
            }else if (SecondPart =~ /([+-\/*])(\d+)/){
                def (all,digit,symbol) = (SecondPart =~ /([+-\/*])(\d+)/)[0]
                output = this.CalcTwoSide(FirstPart, symbol, digit)
            }else{
                def (digit) = (SecondPart =~ /(\d+)/)[0]
                output = this.CalcTwoSide(FirstPart, "*", digit)
            }
        }else{
            if (expression =~ /(.+)([+])(.+)/){
                def (Allstring, LeftPart, MainSymbol, RightPart) = ((expression =~ /(.+)([+])(.+)/)[0])
                if (LeftPart =~ /[+-\/*]/){
                    def (All, Left, Symbol, Right) = ((LeftPart =~ /(.+)([+-\/*])(.+)/)[0])
                    output = this.CalcTwoSide(Left, Symbol, Right)
                    output = this.CalcTwoSide(output, MainSymbol, RightPart)
                }else{
                    def (All, Left, Symbol, Right) = ((RightPart =~ /(.+)([+-\/*])(.+)/)[0])
                    output = this.CalcTwoSide(Left, Symbol, Right)
                    output = this.CalcTwoSide(LeftPart, MainSymbol, output)
                }
            }else if (expression =~ /(.+)([-])(.+)/){
                def (Allstring, LeftPart, MainSymbol, RightPart) = ((expression =~ /(.+)([-])(.+)/)[0])
                if (LeftPart =~ /[+-\/*]/){
                    def (All, Left, Symbol, Right) = ((LeftPart =~ /(.+)([+-\/*])(.+)/)[0])
                    output = this.CalcTwoSide(Left, Symbol, Right)
                    output = this.CalcTwoSide(output, MainSymbol, RightPart)
                }else{
                    def (All, Left, Symbol, Right) = ((RightPart =~ /(.+)([+-\/*])(.+)/)[0])
                    output = this.CalcTwoSide(Left, Symbol, Right)
                    output = this.CalcTwoSide(LeftPart, MainSymbol, output)
                }
            }else if (expression =~ /(.+)([*])(.+)/){
                def (Allstring, LeftPart, MainSymbol, RightPart) = ((expression =~ /(.+)([*])(.+)/)[0])
                if (LeftPart =~ /[+-\/*]/){
                    def (All, Left, Symbol, Right) = ((LeftPart =~ /(.+)([+-\/*])(.+)/)[0])
                    output = this.CalcTwoSide(Left, Symbol, Right)
                    output = this.CalcTwoSide(output, MainSymbol, RightPart)
                }else{
                    def (All, Left, Symbol, Right) = ((RightPart =~ /(.+)([+-\/*])(.+)/)[0])
                    output = this.CalcTwoSide(Left, Symbol, Right)
                    output = this.CalcTwoSide(LeftPart, MainSymbol, output)
                }
            }else if (expression =~ /(.+)([\/])(.+)/){
                def (Allstring, LeftPart, MainSymbol, RightPart) = ((expression =~ /(.+)([\/])(.+)/)[0])
                if (LeftPart =~ /[+-\/*]/){
                    def (All, Left, Symbol, Right) = ((LeftPart =~ /(.+)([+-\/*])(.+)/)[0])
                    output = this.CalcTwoSide(Left, Symbol, Right)
                    output = this.CalcTwoSide(output, MainSymbol, RightPart)
                }else{
                    def (All, Left, Symbol, Right) = ((RightPart =~ /(.+)([+-\/*])(.+)/)[0])
                    output = this.CalcTwoSide(Left, Symbol, Right)
                    output = this.CalcTwoSide(LeftPart, MainSymbol, output)
                }
            }
        }
        return (output.toInteger())
    }
}
