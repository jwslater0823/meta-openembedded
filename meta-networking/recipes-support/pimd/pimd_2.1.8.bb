SUMMARY = "pimd is a lightweight stand-alone PIM-SM v2 multicast routing daemon."
HOMEPAGE = "http://troglobit.com/pimd.html"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=94f108f91fab720d62425770b70dd790"

SRC_URI = "ftp://troglobit.com/pimd/${BP}.tar.bz2"
SRC_URI[md5sum] = "a12448bc7c9bfcebf51a13ebf1ffa962"
SRC_URI[sha256sum] = "3379436c16caccdef9b40a49fbdfdbb45aad8ecb05870834490b8fb080126009"

CFLAGS += "-I ${S}/include "
