package shop.mtcoding.blog.board;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardRepository boardRepository;

    @DeleteMapping("/api/boards/{id}")
    public ApiUtil<?> deleteById(@PathVariable Integer id, HttpServletResponse response){
        Board board = boardRepository.selectOne(id);
        if (board == null){
            response.setStatus(404);
            return new ApiUtil<>(404,"해당 게시글을 찾을 수 없습니다.");
        }

        boardRepository.deleteById(id);
        return new ApiUtil<>(null); // 삭제 잘 됐어? OK HTML 전체를 다운 받을 필요 X
    }

    @GetMapping("/api/boards") // api 주소를 복수형으로 쓴다
    public ApiUtil<?> findAll(HttpServletResponse response){ // <List<Board>>
//        response.setStatus(401);
        List<Board> boardList = boardRepository.selectAll(); // 상태코드와 메시지를 줘야한다.
        return new ApiUtil<>(boardList); //status 코드 확인 200인지 MessageConverter 발동 (JSON으로 알아서 바꿔줌)

    }
}
