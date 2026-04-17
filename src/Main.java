import model.Funcionario;
import service.FuncionarioService;
import util.CalculadoraUtil;
import util.FormatadorUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");

    public static void main(String[] args) {
        FuncionarioService service = new FuncionarioService();

        List<Funcionario> funcionarios = inicializarFuncionarios();
        imprimirTitulo("LISTA DE FUNCIONÁRIOS");
        imprimirListaFuncionarios(funcionarios);

        service.removerFuncionarioPorNome(funcionarios, "João");

        imprimirTitulo("LISTA DE FUNCIONÁRIOS APÓS A REMOÇÃO DO FUNCIONÁRIO JOÃO");
        imprimirListaFuncionarios(funcionarios);

        service.aplicarAumento(funcionarios, new BigDecimal("10.0"));
        System.out.println("\n[!] Aumento de 10% aplicado a todos os funcionários.");
        imprimirTitulo("LISTA DE FUNCIONÁRIOS APÓS O AUMENTO DE 10%");
        imprimirListaFuncionarios(funcionarios);

        Map<String, List<Funcionario>> funcionariosPorFuncao = service.agruparPorFuncao(funcionarios);

        imprimirTitulo("FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(f -> System.out.println("  - " + f.getNome()));
        });

        imprimirTitulo("ANIVERSARIANTES (MÊS 10 e 12)");
        List<Funcionario> aniversariantes = service.buscarAniversariantes(funcionarios, Arrays.asList(10, 12));
        aniversariantes.forEach(f ->
                System.out.println(f.getNome() + " - " + FormatadorUtil.formatarData(f.getDataNascimento()))
        );

        imprimirTitulo("FUNCIONÁRIO MAIS VELHO");
        service.encontrarFuncionarioMaisVelho(funcionarios).ifPresent(maisVelho -> {
            int idade = CalculadoraUtil.calcularIdade(maisVelho.getDataNascimento());
            System.out.println("Nome: " + maisVelho.getNome() + ", Idade: " + idade + " anos");
        });

        imprimirTitulo("FUNCIONÁRIOS (ORDEM ALFABÉTICA)");
        List<Funcionario> funcionariosOrdenados = service.ordenarAlfabeticamente(funcionarios);
        funcionariosOrdenados.forEach(f -> System.out.println(f.getNome()));

        imprimirTitulo("TOTAL DE SALÁRIOS");
        BigDecimal totalSalarios = service.calcularTotalSalarios(funcionarios);
        System.out.println("Total: " + FormatadorUtil.formatarValorBRL(totalSalarios));

        imprimirTitulo("QUANTIDADE DE SALÁRIOS MÍNIMOS (Base: 1212,00)");
        funcionarios.forEach(f -> {
            BigDecimal qtdSalariosMinimos = service.calcularSalariosMinimos(f.getSalario(), SALARIO_MINIMO);
            System.out.println(f.getNome() + ": " + FormatadorUtil.formatarValorBRL(qtdSalariosMinimos) + " salários mínimos");
        });
    }

    private static List<Funcionario> inicializarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        return funcionarios;
    }

    private static void imprimirListaFuncionarios(List<Funcionario> funcionarios) {
        for (Funcionario f : funcionarios) {
            System.out.printf("Nome: %-10s | Nasc: %s | Salário: %10s | Função: %s%n",
                    f.getNome(),
                    FormatadorUtil.formatarData(f.getDataNascimento()),
                    FormatadorUtil.formatarValorBRL(f.getSalario()),
                    f.getFuncao());
        }
    }

    private static void imprimirTitulo(String titulo) {
        System.out.println("\n--------------------------------------------------------");
        System.out.println(titulo);
        System.out.println("--------------------------------------------------------");
    }
}