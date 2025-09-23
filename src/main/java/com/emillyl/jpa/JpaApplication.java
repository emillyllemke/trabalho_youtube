package com.emillyl.jpa;

import com.emillyl.jpa.Entity.*;
import com.emillyl.jpa.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class JpaApplication {
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	@Bean
	CommandLineRunner run(
			UsuarioRepository usuarioRepo,
			CategoriaRepository categoriaRepo,
			VideoRepository videoRepo,
			PerfilRepository perfilRepo,
			VisualizacaoRepository visualizacaoRepo,
			AvaliacaoRepository avaliacaoRepo
	) {
		return args -> {
			// Categorias
			Categoria c1 = new Categoria("Programação");
			categoriaRepo.save(c1);
			Categoria c2 = new Categoria("Carreira e Tecnologia");
			categoriaRepo.save(c2);
			Categoria c3 = new Categoria("Banco de Dados");
			categoriaRepo.save(c3);

			// Usuários
			Usuario u1 = new Usuario(null, "Ana Silva", "ana@email.com", "ana123", LocalDateTime.now().minusDays(10), null);
			usuarioRepo.save(u1);
			Usuario u2 = new Usuario(null, "Bruno Costa", "bruno@email.com", "bruno123", LocalDateTime.now().minusDays(5), null);
			usuarioRepo.save(u2);
			Usuario u3 = new Usuario(null, "Carlos Dias", "carlos@email.com", "carlos123", LocalDateTime.now().minusDays(2), null);
			usuarioRepo.save(u3);
			Usuario u4 = new Usuario(null, "Maria Koch", "mariakoch@gmail.com", "maria123",
					LocalDateTime.of(2025, 11, 2, 10, 22, 1), null);
			usuarioRepo.save(u4);

			// Perfis
			Perfil p1 = new Perfil(null, "Ana-Principal", u1);
			perfilRepo.save(p1);
			Perfil p2 = new Perfil(null, "Bruno-Dev", u2);
			perfilRepo.save(p2);
			Perfil p3 = new Perfil(null, "Carlos-Estudos", u3);
			perfilRepo.save(p3);
			Perfil p4 = new Perfil(null, "Carlos-Kids", u3); // Segundo perfil do Carlos
			perfilRepo.save(p4);
			Perfil p5 = new Perfil (null, "Maria Linda", u4);
			perfilRepo.save(p5);

			// Vídeos
			Video v1 = new Video(null,"Introdução a JAVA", "Conceitos básicos de Java.", 1200L, c1);
			videoRepo.save(v1);
			Video v2 = new Video(null, "SQL para Iniciantes", "Aprenda SQL do zero.", 2500L, c1);
			videoRepo.save(v2);
			Video v3 = new Video(null, "O que é uma API?", "Entenda o conceito de API.", 800L, c2);
			videoRepo.save(v3);
			Video v4 = new Video(null, "Como conseguir o primeiro emprego DEV", "Dicas de carreira.", 1500L, c2);
			videoRepo.save(v4);
			Video v5 = new Video(null, "Java Avançado: Streams e Lambdas", "Aprenda a usar Streams e Lambdas em Java.", 3200L, c1);
			videoRepo.save(v5);
			Video v6 = new Video(null, "Entrevista Técnica: Dicas Essenciais", "Prepare-se para entrevistas de emprego na área de TI.", 1100L, c2);
			videoRepo.save(v6);
			Video v7 = new Video(null, "Índices em Bancos de Dados", "Otimize suas consultas com índices.", 1900L, c3);
			videoRepo.save(v7);
			Video v8 = new Video(null, "Spring Boot: Sua Primeira API", "Crie uma API REST com Spring Boot.", 4000L, c1);
			videoRepo.save(v8);
			Video v9 = new Video(null, "Trabalho Remoto: Prós e Contras", "Análise sobre o modelo de trabalho remoto.", 950L, c2);
			videoRepo.save(v9);
			Video v10 = new Video(null, "MongoDB vs SQL: Qual escolher?", "Comparativo entre bancos de dados relacionais e NoSQL.", 2100L, c3);
			videoRepo.save(v10);
			Video v11 = new Video(null, "Como usar o Github","Instruções de como usar o Github, fazer commit", 1000L, c2);
			videoRepo.save(v11);

			// --- VISUALIZAÇÕES E AVALIAÇÕES ---

			// Ana (p1) assiste e avalia
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 1200L, p1, v1));
			avaliacaoRepo.save(new Avaliacao(null, 5L, "Ótimo!", p1, v1));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 700L, p1, v4));
			avaliacaoRepo.save(new Avaliacao(null, 4L, "Gostei.", p1, v4));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 4000L, p1, v8));
			avaliacaoRepo.save(new Avaliacao(null, 5L, "O melhor tutorial de Spring que já vi!", p1, v8));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 2100L, p1, v10));
			avaliacaoRepo.save(new Avaliacao(null, 5L, "Abriu minha mente!", p1, v10));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 1100L, p1, v6));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 950L, p1, v9));
			avaliacaoRepo.save(new Avaliacao(null, 5L, "Conteúdo de alta qualidade!", p1, v5));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 850L, p1, v1));

			// Bruno (p2) assiste e avalia
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 1200L, p2, v1));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 2500L, p2, v2));
			avaliacaoRepo.save(new Avaliacao(null, 4L, "Bom curso.", p2, v2));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 800L, p2, v3));
			avaliacaoRepo.save(new Avaliacao(null, 5L, "Excelente explicação!", p2, v3));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 1500L, p2, v7));
			avaliacaoRepo.save(new Avaliacao(null, 4L, "Explicação de mestre.", p2, v7));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 4000L, p2, v8));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 1000L, p2, v10));
			avaliacaoRepo.save(new Avaliacao(null, 2L, "Não concordo com a abordagem.", p2, v10));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 1100L, p2, v6));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 1000L, p2, v11));
			avaliacaoRepo.save(new Avaliacao(null, 4L, "Muito útil para iniciantes.", p2, v11));
			avaliacaoRepo.save(new Avaliacao(null, 5L, "Didática impecável!", p2, v5));

			// Carlos (p3 e p4) assiste MUITO
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 1000L, p3, v1));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 2500L, p3, v2));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 800L, p3, v3));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 1500L, p4, v4));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 1300L, p3, v2));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 400L, p4, v3));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 3200L, p3, v7));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 4000L, p3, v8));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 4000L, p4, v8));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 1100L, p3, v6));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 950L, p3, v9));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 1900L, p4, v7));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 1200L, p3, v1));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 1200L, p4, v1));
			avaliacaoRepo.save(new Avaliacao(null, 4L, "Muito claro!", p3, v3));
			avaliacaoRepo.save(new Avaliacao(null, 3L, "Dicas ok, podia ser melhor.", p4, v6));
			avaliacaoRepo.save(new Avaliacao(null, 5L, "Aprendi muito.", p3, v7));
			avaliacaoRepo.save(new Avaliacao(null, 3L, "Dicas muito práticas.", p4, v6));
			avaliacaoRepo.save(new Avaliacao(null, 4L, "Essencial para qualquer DEV.", p3, v11));
			avaliacaoRepo.save(new Avaliacao(null, 4L, "Bom, mas poderia ser mais detalhado.", p3, v8));
			avaliacaoRepo.save(new Avaliacao(null, 5L, "Recomendo a todos!", p4, v5));
			avaliacaoRepo.save(new Avaliacao(null, 3L, "Nada demais pra quem já conhece a Linguagem", p4, v1));

			//Maria (p5) assiste e avalia
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 1200L, p5, v1));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 300L, p5, v2));
			avaliacaoRepo.save(new Avaliacao(null, 4L, "Ótimo!", p5, v2));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 4000L, p5, v8));
			avaliacaoRepo.save(new Avaliacao(null, 5L, "Indispensável!", p5, v8));
			avaliacaoRepo.save(new Avaliacao(null, 3L, "Razoável, mas superficial.", p5, v10));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 2500L, p5, v2));
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 3200L, p5, v5));
			avaliacaoRepo.save(new Avaliacao(null, 5L, "Excelente conteúdo avançado!", p5, v5));
			avaliacaoRepo.save(new Avaliacao(null, 4L, "Bom para ter uma visão geral.", p5, v9));

			// Select
			System.out.println("\n=== Lista de Usuários ===");
			usuarioRepo.findAll().forEach(usuario ->
					System.out.println(usuario.getId() + " - " + usuario.getNome())
			);

			System.out.println("\n=== Lista de Vídeos ===");
			videoRepo.findAll().forEach(v ->
					System.out.println(v.getId() + " - " + v.getTitulo() + " (" + v.getCategoria().getNome_categoria() + ")")
			);

			System.out.println("\n=== Ordenar pelo Título JAVA===");
			List<Video> videosEncontrados = videoRepo.findByTituloContainingOrderByTitulo("JAVA");
			videosEncontrados.forEach(v -> System.out.println(v.getId() +"-" +v.getTitulo()+ "-"+ v.getDescricao()));

			System.out.println("\n=== Ordenar pelos Vídeos da Categoria ===");
			List<Video> videosPorCategoria = videoRepo.findByCategoriaOrderByTitulo(c1);
			videosPorCategoria.forEach(v -> System.out.println(v.getId()+"-"+v.getTitulo()+ "-"+ v.getDescricao()));

			System.out.println("\n=== Top 10 Vídeos Mais Bem Avaliados ===");
			Pageable pageable = PageRequest.of(0, 10);
			List<Video> topVideos = avaliacaoRepo.findTopMelhoresVideos(pageable);
			for (int i = 0; i < topVideos.size(); i++) {
				Video video = topVideos.get(i);
				System.out.println((i + 1) + ". " + video.getTitulo());
			}

			System.out.println("\n=== Top 10 Vídeos Mais Visualizados ===");
			List<Video> videosVisualizados = visualizacaoRepo.findTopVideosAssistidos(pageable);
			for (int i = 0; i < videosVisualizados.size(); i++) {
				Video video = videosVisualizados.get(i);
				System.out.println((i + 1) + ". " + video.getTitulo());
			}

			System.out.println("\n=== Usuário que mais visualizou Vídeos ===");
			Pageable topOne = PageRequest.of(0, 1);
			List<Usuario> topUsuario = visualizacaoRepo.findTopUsuariosByVisualizacao(topOne);
			if (!topUsuario.isEmpty()) {
				Usuario melhorUsuario = topUsuario.get(0);
				System.out.println("O usuário que mais assistiu foi: " + melhorUsuario.getNome());
			} else {
				System.out.println("Nenhum dado de visualização encontrado.");
			}

		};
	}
}


