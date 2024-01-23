package br.com.sabedoria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.sabedoria.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private CustomUserDetailsService userDetailsServiceImpl;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.csrf(csrf -> csrf.disable())
	            .authorizeHttpRequests((authorize) -> authorize
	                    .requestMatchers("/", "/planos" ,"/sobreNos", "/planos", "/mentores", "/login", "/cadastro", "/cadastrarMentor", "/cadastrarMentorado", "/sucesso", "/style/**", "/img/**", "/video/**", "/adminlte/**", "/dist/**", "/plugins/**", "/script/**" )
	                            .permitAll()
	                    .requestMatchers("/listar", "/perfil", "/listarMentor", "/teste", "/mentor/{id}/excluir", "/{id}/editarMentor", "/imagemMentor/{id}", "/imagem/{id}","/{id}/editar", "/{id}/excluir", "/cadastrarMonitoria", "/listarMonitorias", "/excluirMonitoria")
	                            .hasAnyAuthority("CLIENTE", "MENTOR")) // Adicionando "MENTOR" à lista de autoridades permitidas
	            .formLogin(form -> form
	            	    .loginPage("/login")
	            	    .loginProcessingUrl("/login")
	            	    .defaultSuccessUrl("/perfil")
	            	    .permitAll())
	            .logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll());

	    return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	  @Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
	}

	

}
