package br.com.sabedoria.serviceImpl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.sabedoria.enums.Perfil;
import br.com.sabedoria.model.Cliente;

public class ClienteUserDetailsImpl implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	
	public ClienteUserDetailsImpl(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getNome() {
		return cliente.getNome();
	}
	
	public String getEmail() {
		return cliente.getEmail();
	}
	
	public Integer getIdade() {
		return cliente.getIdade();
	}
	
	public String getProfissao() {
		return cliente.getProfissao();
	}
	
	public String getEndereco() {
		return cliente.getEndereco();
	}
	
	public byte[] getImagem() {
		return cliente.getImagem();
	}
	
    public Long getId() {
        return cliente.getId();  // supondo que você tenha um método getId() na classe Mentor
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Perfil perfil = cliente.getPerfil();
		return AuthorityUtils.createAuthorityList(perfil.toString());
	}

	@Override
	public String getPassword() {
		return cliente.getSenha();
	}

	@Override
	public String getUsername() {
		return cliente.getEmail();
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
