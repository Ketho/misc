global _main
extern _printf
extern _ExitProcess@4

section data
msg:
	db "Hello World!"

section code
_main:
	push	dword msg
	call	_printf

	push	 dword 0		; UINT uExitCode
	call	_ExitProcess@4
