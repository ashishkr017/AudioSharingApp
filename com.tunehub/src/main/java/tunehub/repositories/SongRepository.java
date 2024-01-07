package tunehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tunehub.entities.Song;

public interface SongRepository extends JpaRepository<Song, Integer>
{

	public Song findByName(String name);

	
	
	
	
	
	
}
