package sport

import java.text.SimpleDateFormat

class DateTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    def longDate = {attrs, body ->
        //разбор полученной даты
        def b = attrs.body ?: body()
        def d = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(b)

        //если атрибут format не задан, то использовать следующий
        def pattern = attrs["format"] ?: "EEEE, MMM d, yyyy"
        out << new SimpleDateFormat(pattern).format(d)
    }
}
