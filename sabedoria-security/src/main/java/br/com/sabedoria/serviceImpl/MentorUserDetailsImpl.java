package br.com.sabedoria.serviceImpl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.sabedoria.enums.Perfil;
import br.com.sabedoria.model.Mentor;

public class MentorUserDetailsImpl implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	private Mentor mentor;
	
	public MentorUserDetailsImpl(Mentor mentor) {
		this.mentor = mentor;
	}
	
	public String getNome() {
		return mentor.getNome();
	}
	
	public String getEmail() {
		return mentor.getEmail();
	}
	
	public Integer getIdade() {
		return mentor.getIdade();
	}
	
	public String getProfissao() {
		return mentor.getProfissao();
	}
	
	public String getEndereco() {
		return mentor.getEndereco();
	}
	
	public byte[] getImagem() {
		return mentor.getImagem();
	}
	
    public Long getId() {
        return mentor.getId();  // supondo que você tenha um método getId() na classe Mentor
    }
	
	
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Perfil perfil = mentor.getPerfil();
		return AuthorityUtils.createAuthorityList(perfil.toString());
	}

	@Override
	public String getPassword() {
		return mentor.getSenha();
	}

	@Override
	public String getUsername() {
		return mentor.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	

}
