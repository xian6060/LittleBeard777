include Irvine32.inc
.data
       ranNum BYTE 3 dup(?)
       filename BYTE "777.txt",0
       fileHandle DWORD ? ; handle to output file
       bytesWritten DWORD ? ; number of bytes written
.code
beard777 PROC
       INVOKE CreateFile,
       ADDR filename, GENERIC_WRITE, DO_NOT_SHARE, NULL,
       CREATE_ALWAYS, FILE_ATTRIBUTE_NORMAL, 0
       mov fileHandle,eax ; save file handle

       mov ecx, 3
       mov esi, offset ranNum
       call Randomize
L1:
       mov  eax,4    ;get random 0 to 99
       call RandomRange ;
       add  eax, 49        ;make range 1 to 100
       mov  [esi],al  ;save random number
       mov	edx,4         ;number of bytes
       inc esi
       loop L1

       INVOKE WriteFile, ; write text to file
       fileHandle, ; file handle
       ADDR ranNum, ; buffer pointer
       3, ; number of bytes to write
       ADDR bytesWritten, ; number of bytes written
       0 ; overlapped execution flag
       INVOKE CloseHandle, fileHandle
       exit
beard777 ENDP
END beard777