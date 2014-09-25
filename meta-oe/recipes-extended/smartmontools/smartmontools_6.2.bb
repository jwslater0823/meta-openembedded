SUMMARY = "Control and monitor storage systems using S.M.A.R.T"
DESCRIPTION = \
"The smartmontools package contains two utility programs (smartctl \
and smartd) to control and monitor storage systems using the Self-\
Monitoring, Analysis and Reporting Technology System (SMART) built \
into most modern ATA and SCSI hard disks. In many cases, these \
utilities will provide advanced warning of disk degradation and failure."

HOMEPAGE = "http://smartmontools.sourceforge.net/"
SECTION = "console/utils"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "${SOURCEFORGE_MIRROR}/smartmontools/smartmontools-${PV}.tar.gz \
           file://initd.smartd \
           file://smartmontools.default \
          "

PACKAGECONFIG ??= "${@base_contains('DISTRO_FEATURES', 'libcap-ng', 'libcap-ng', '', d)} \
                   ${@base_contains('DISTRO_FEATURES', 'selinux', 'selinux', '', d)} \
                  "
PACKAGECONFIG[libcap-ng] = "--with-libcap-ng=yes,--with-libcap-ng=no,libcap-ng"
PACKAGECONFIG[selinux] = "--with-selinux=yes,--with-selinux=no,libselinux"

SRC_URI[md5sum] = "d44f84081a12cef79cd17f78044351fc"
SRC_URI[sha256sum] = "486f660579bb0fb4f6b927ded7531cb1f99685c666397377761c5b04dd96065b"

inherit autotools update-rc.d

do_install_append () {
	#install the init.d/smartd
	install -d ${D}${sysconfdir}/init.d
	install -p -m 0755 ${WORKDIR}/initd.smartd ${D}${sysconfdir}/init.d/smartd
	install -d ${D}${sysconfdir}/default
	install -p -m 0644 ${WORKDIR}/smartmontools.default ${D}${sysconfdir}/default/smartmontools
}

INITSCRIPT_NAME = "smartd"
INITSCRIPT_PARAMS = "start 60 2 3 4 5 . stop 60 0 1 6 ."

RDEPENDS_${PN} += "mailx"
