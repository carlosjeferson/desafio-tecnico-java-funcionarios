package service;

import model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FuncionarioService {

    public void removerFuncionarioPorNome(List<Funcionario> funcionarios, String nome) {
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
    }

    public void aplicarAumento(List<Funcionario> funcionarios, BigDecimal percentualAumento) {
        BigDecimal fatorMultiplicacao = BigDecimal.ONE.add(percentualAumento.divide(new BigDecimal("100")));

        funcionarios.forEach(f -> {
            BigDecimal novoSalario = f.getSalario().multiply(fatorMultiplicacao);
            f.setSalario(novoSalario);
        });
    }

    public Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public List<Funcionario> buscarAniversariantes(List<Funcionario> funcionarios, List<Integer> meses) {
        return funcionarios.stream()
                .filter(f -> meses.contains(f.getDataNascimento().getMonthValue()))
                .toList();
    }

    public Optional<Funcionario> encontrarFuncionarioMaisVelho(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento));
    }

    public List<Funcionario> ordenarAlfabeticamente(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .toList();
    }

    public BigDecimal calcularTotalSalarios(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calcularSalariosMinimos(BigDecimal salarioFuncionario, BigDecimal salarioMinimo) {
        return salarioFuncionario.divide(salarioMinimo, 2, RoundingMode.HALF_UP);
    }
}