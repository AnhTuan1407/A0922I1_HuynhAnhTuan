import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
    public static void main(String[] args) {
        final String SDT = "0[1-9]\\d{8}";
        final String CCCD = "\\d{12}";
        final String BSX = "43-[A-Z][1-9]-((\\d{4})|(\\d{3}.\\d{2}))";
        final String EMAIL = "\\w+@\\w+.[A-Za-z]{2,3}";

//        System.out.println("43-H1-1234".matches(BSX));
//        System.out.println("43-H1-12345".matches(BSX));
//        System.out.println("43-H1-123.45".matches(BSX));
//        System.out.println("43-H1-12.345".matches(BSX));
        System.out.println("aaaa".matches(EMAIL));
        System.out.println("aaaa@bbb.ccccc".matches(EMAIL));
        System.out.println("aaaa@bbb.ccc".matches(EMAIL));
        System.out.println("aaaa@bbb.c".matches(EMAIL));
        System.out.println("aaaa@111.11".matches(EMAIL));
        System.out.println("aaaa@aa.aa.a".matches(EMAIL));


        String text1 = "Hello java regex 2-12-2018, hello world 12/12/2018";

        Pattern pattern = Pattern.compile("\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}");

        Matcher matcher = pattern.matcher(text1);

        System.out.println("Ngày tháng trong chuỗi text1: " + text1);

        while (matcher.find()) {

            System.out.println(text1.substring(matcher.start(), matcher.end()));

        }


        String text2 = "2/12/2018";

        String text3 = "12/12/aaaa";

        pattern = Pattern.compile("^\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}$");

        System.out.println("\nChuỗi " + text2 + " có định dạng ngày tháng: "

                + pattern.matcher(text2).matches());

        System.out.println("Chuỗi " + text3 + " có định dạng ngày tháng: "

                + pattern.matcher(text3).matches());

    }


}
