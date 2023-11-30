package io.github.marabezzi.startersecurity.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.function.Function;

import org.springframework.stereotype.Service;

@Service
public class JwtService {
	
	private static final String SECRET_KEY = "i+h7fdgoGyBCV9N6NdR1IqKpncqBHmcJQ9KODz8NwhX1Qp/LlC2tUXx8AzVUrX49";
	
	
	public String  extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	public <T> T extractAllClaims(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts
				.parserBuilder()
				.setSigningKey(getSignInKey())
				.build()
				.parseClaimsJwt(token)
				.getBody();
	}
	
	private Key getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
