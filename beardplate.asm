include Irvine32.inc
.data
       ranNum BYTE ?
       filename BYTE "plate.txt",0
       fileHandle DWORD ? ; handle to output file
       bytesWritten DWORD ? ; number of bytes written
.code
beardplate PROC
       INVOKE CreateFile,
       ADDR filename, GENERIC_WRITE, DO_NOT_SHARE, NULL,
       CREATE_ALWAYS, FILE_ATTRIBUTE_NORMAL, 0
       mov fileHandle,eax ; save file handle

       call Randomize
       mov  eax,9    ;get random 0 to 99
       call RandomRange ;
       add  eax, 49        ;make range 1 to 100
       mov  ranNum,al  ;save random number
       mov	edx,4         ;number of bytes

       INVOKE WriteFile, ; write text to file
       fileHandle, ; file handle
       ADDR ranNum, ; buffer pointer
       1, ; number of bytes to write
       ADDR bytesWritten, ; number of bytes written
       0 ; overlapped execution flag
       INVOKE CloseHandle, fileHandle
       exit
beardplate ENDP
END beardplate