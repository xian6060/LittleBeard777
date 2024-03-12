include Irvine32.inc
.data
       ranNum BYTE 2 dup(?)
       filename BYTE "horse.txt",0
       fileHandle DWORD ? ; handle to output file
       bytesWritten DWORD ? ; number of bytes written
.code
beard21_1 PROC
       INVOKE CreateFile,
       ADDR filename, GENERIC_WRITE, DO_NOT_SHARE, NULL,
       CREATE_ALWAYS, FILE_ATTRIBUTE_NORMAL, 0
       mov fileHandle,eax ; save file handle

       mov esi, offset ranNum
       call Randomize
       mov  eax,12    ;get random 0 to 99
       call RandomRange ;
       inc eax
       mov cl, 10
       div cl

       add  al, 48        ;make range 1 to 100
       mov  [esi],al  ;save random number
       inc esi
       add  ah, 48
       mov  [esi],ah
       mov	edx,4         ;number of bytes

       INVOKE WriteFile, ; write text to file
       fileHandle, ; file handle
       ADDR ranNum, ; buffer pointer
       2, ; number of bytes to write
       ADDR bytesWritten, ; number of bytes written
       0 ; overlapped execution flag
       INVOKE CloseHandle, fileHandle
       exit
beard21_1 ENDP
END beard21_1