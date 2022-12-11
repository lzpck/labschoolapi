package tech.devinhouse.labschoolapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import tech.devinhouse.labschoolapi.model.Aluno;
import tech.devinhouse.labschoolapi.model.Pedagogo;
import tech.devinhouse.labschoolapi.model.Professor;
import tech.devinhouse.labschoolapi.service.AlunoService;
import tech.devinhouse.labschoolapi.service.PedagogoService;
import tech.devinhouse.labschoolapi.service.ProfessorService;

import java.time.LocalDate;

@SpringBootApplication
public class LabschoolapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabschoolapiApplication.class, args);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages.properties");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    @Bean
    CommandLineRunner runnerAluno (AlunoService alunoService) {
        LocalDate localDate = LocalDate.now();
        return args -> {
            if (alunoService.consultar().isEmpty()) {
                alunoService.salvar(new Aluno(null, "Bart Simpson", "11-11111-1212", localDate.of(2014, 10, 29), 11839750073l, "IRREGULAR", 3.5f));
                alunoService.salvar(new Aluno(null, "Lisa Simpson", "11-22222-2222", localDate.of(2012, 10, 29), 17158947076l, "ATIVO", 10f));
                alunoService.salvar(new Aluno(null, "Meggie Simpson", "12-20002-2200", localDate.of(2019, 10, 29), 63701210020l, "ATIVO", 9f));
                alunoService.salvar(new Aluno(null, "Milhouse Van Houten", "11-33333-2222", localDate.of(2014, 10, 29), 30119137062l, "ATIVO", 8f));
                alunoService.salvar(new Aluno(null, "Nelson Muntz", "11-44333-4444", localDate.of(2007, 10, 29), 95704094015l, "INATIVO", 2f));

            }
        };
    }

    @Bean
    CommandLineRunner runnerProfessor (ProfessorService professorService) {
        LocalDate localDate = LocalDate.now();
        return args -> {
            if (professorService.consultar().isEmpty()) {
                professorService.salvar(new Professor(null, "Walter White", "14-22998-1882", localDate.of(1982, 10, 30), 40539019011l, "MESTRADO", "FULL_STACK", "ATIVO"));
                professorService.salvar(new Professor(null, "Jesse Pinkman", "44-11111-1992", localDate.of(1997, 10, 30), 96107295097l, "GRADUACAO_INCOMPLETA", "BACK_END", "ATIVO"));
                professorService.salvar(new Professor(null, "Hank Schrader", "44-11111-1002", localDate.of(1984, 10, 30), 70685977005l, "MESTRADO", "FULL_STACK", "ATIVO"));
                professorService.salvar(new Professor(null, "Gustavo Fring", "44-11001-1002", localDate.of(1977, 10, 30), 57408927085l, "GRADUACAO_COMPLETA", "FULL_STACK", "INATIVO"));
                professorService.salvar(new Professor(null, "Saul Goodman", "44-11998-1882", localDate.of(1980, 10, 30), 86940162062l, "MESTRADO", "FULL_STACK", "ATIVO"));

            }
        };
    }

    @Bean
    CommandLineRunner runnerPedagogo (PedagogoService pedagogoService) {
        LocalDate localDate = LocalDate.now();
        return args -> {
            if (pedagogoService.consultar().isEmpty()) {
                pedagogoService.salvar(new Pedagogo(null, "John Snow", "11-67333-4454", localDate.of(2000, 10, 30), 62316840086l));
                pedagogoService.salvar(new Pedagogo(null, "Sansa Stark", "22-22333-4454", localDate.of(2004, 10, 30), 49850253053l));
                pedagogoService.salvar(new Pedagogo(null, "Tyrion Lannister", "33-77333-4454", localDate.of(1990, 10, 30), 39125106015l));
                pedagogoService.salvar(new Pedagogo(null, "Sandor Clegane", "11-33333-2222", localDate.of(1995, 10, 30), 89089606009l));
            }
        };
    }
}
