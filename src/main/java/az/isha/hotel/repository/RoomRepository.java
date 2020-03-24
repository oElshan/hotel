package az.isha.hotel.repository;

import az.isha.hotel.entity.Rooms;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface RoomRepository extends CrudRepository<Rooms, Long> {

//    @Query("SELECT p from Post p WHERE p.user IN :users ORDER BY p.timeStamp DESC")
//    public List<Post> find(@Param("users") Set<User> followingList);

    List<Rooms> findAll();

}
