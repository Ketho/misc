global main
extern printf
extern ExitProcess

section data
	msg:	db "Hello World!"

section code
main:
	mov		rcx, dword msg
	call	printf

	mov		rcx, dword 0		; UINT uExitCode
	call	ExitProcess
