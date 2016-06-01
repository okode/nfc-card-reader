NFC Card Reader and Card Emulator
=================================

Simple NFC Card Reader and Emulator Demos

* Android App Reader
* Mac OS X App Reader with Keyboard emulation
* Android App Card Emulator

Emulating Card
--------------

Use ACR122U with ACR122U PC/SC Scripting Tool

Test script:

    ; AID selection (AID = 01 02 03 04 05 06)
    00 A4 04 00 07 F0 01 02 03 04 05 06 (9000)
    
    ; Custom command
    80 20 00 00 12 34 (9000)
