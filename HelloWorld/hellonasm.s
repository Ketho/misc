global _main
extern _printf
extern _ExitProcess@4

section data use32 class=data
	msg:	db "Hello World!"

section code use32 class=code
_main:
	push	dword msg
	call	_printf

	push	dword 0				; UINT uExitCode
	call	_ExitProcess@4
