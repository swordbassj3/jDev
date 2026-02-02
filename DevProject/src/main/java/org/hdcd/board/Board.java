package org.hdcd.board;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of="boardNo")
@ToString
public class Board {

	 private Integer boardNo;
	 private String boardTitle;
	 private String boardContent;
	 private String boardWriter;
	 private LocalDateTime regDate;
	 private LocalDateTime modDate;
	 private String useYn;
	 private Integer boardCnt;
}
