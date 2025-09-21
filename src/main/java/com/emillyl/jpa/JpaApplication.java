package com.emillyl.jpa;

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

			// --- VISUALIZAÇÕES E AVALIAÇÕES ---

			// Ana (p1) assiste e avalia
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 1200L, p1, v1));
			avaliacaoRepo.save(new Avaliacao(null, 5L, "Ótimo!", p1, v1));

			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 700L, p1, v4));
			avaliacaoRepo.save(new Avaliacao(null, 4L, "Gostei.", p1, v4));

			// Bruno (p2) assiste e avalia
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 2500L, p2, v2)); // Assistiu SQL
			avaliacaoRepo.save(new Avaliacao(null, 4L, "Bom curso.", p2, v2));

			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 800L, p2, v3)); // Assistiu API
			avaliacaoRepo.save(new Avaliacao(null, 5L, "Excelente explicação!", p2, v3));

			// Carlos (p3 e p4) assiste MUITO
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 1000L, p3, v1)); // Java
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 2500L, p3, v2)); // SQL
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 800L, p3, v3)); // API
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 1500L, p4, v4)); // Carreira
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 1300L, p3, v2)); // SQL de novo
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 400L, p4, v3)); // API de novo
			avaliacaoRepo.save(new Avaliacao(null, 5L, "Muito claro!", p3, v3));

			//Maria (p5) assiste e avalia
			visualizacaoRepo.save(new Visualizacao(null, LocalDateTime.now(), 300L, p5, v2));
			avaliacaoRepo.save(new Avaliacao(null, 4L, "Ótimo!", p5, v2));

			System.out.println("\n--- DADOS DE TESTE INSERIDOS COM SUCESSO ---");

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
			videosEncontrados.forEach(v -> System.out.println(v.getTitulo()+ "-"+ v.getDescricao()));

			System.out.println("\n=== Ordenar pelos Vídeos da Categoria ===");
			List<Video> videosPorCategoria = videoRepo.findByCategoriaOrderByTitulo(c1);
			videosPorCategoria.forEach(v -> System.out.println(v.getTitulo()+ "-"+ v.getDescricao()));

			System.out.println("\n=== Top 10 Vídeos Mais Bem Avaliados ===");
			Pageable pageable = PageRequest.of(0, 10);
			List<Video> topVideos = avaliacaoRepo.findTopMelhoresVideos(pageable);
			topVideos.forEach(video ->
					System.out.println("Vídeo: " + video.getTitulo())
			);

			System.out.println("\n=== Top 10 Vídeos Mais Visualizados ===");
			List<Video> videosVisualizados = visualizacaoRepo.findTopVideosAssistidos(pageable);
			videosVisualizados.forEach(video ->
					System.out.println("Vídeo: " + video.getTitulo())
			);

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


