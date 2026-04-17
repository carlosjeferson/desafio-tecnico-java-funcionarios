package util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatadorUtil {
    private static final DateTimeFormatter FORMATADOR_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final NumberFormat FORMATADOR_NUMERICO = NumberFormat.getNumberInstance(new Locale("pt", "BR"));

    static {
        FORMATADOR_NUMERICO.setMinimumFractionDigits(2);
        FORMATADOR_NUMERICO.setMaximumFractionDigits(2);
    }

    private FormatadorUtil() {
    }

    public static String formatarData(LocalDate data) {
        if (data == null) return "";
        return data.format(FORMATADOR_DATA);
    }

    public static String formatarValorBRL(BigDecimal valor) {
        if (valor == null) return "";
        return FORMATADOR_NUMERICO.format(valor);
    }
}