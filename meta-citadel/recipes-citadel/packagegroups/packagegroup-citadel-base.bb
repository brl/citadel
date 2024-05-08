#
# Base set of packages, should not include anything needed only on desktop
#

PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup

BASH_COMPLETION = "\
    bash-completion \
    iproute2-bash-completion \
    glib-2.0-bash-completion \
    systemd-bash-completion \
    util-linux-bash-completion \
"

RDEPENDS:${PN} = "\
    keyutils \
    citadel-config \
    base-files \
    base-passwd \
    systemd \
    systemd-conf \
    systemd-container \
    syslinux \
    syslinux-extlinux \
    keymaps \
    kbd \
    nnn \
    console-tools \
    coreutils \
    gzip \
    less \
    util-linux \
    net-tools \
    iputils-ping \
    which \
    parted \
    hdparm \
    bash \
    ${BASH_COMPLETION} \
    grep \
    procps \
    psmisc-extras \
    tar \
    pciutils \
    sysfsutils \
    vim-tiny \
    nano \
    tzdata \
    tzdata-americas \
    tzdata-asia \
    tzdata-europe \
    tzdata-posix \
    glibc-charmap-utf-8 \
    lvm2 \
    findutils \
    lsof \
    strace \
    iproute2 \
    util-linux-hwclock \
    util-linux-blkid \
    util-linux-fstrim \
    btrfs-tools \
    systemd-analyze \
    wget \
    sed \
    xz \
    openssh-ssh \
    cryptsetup \
    e2fsprogs \
    e2fsprogs-resize2fs \
    dosfstools \
    libpam \
    libpam-pwdfile \
    mkpasswd \
    wireguard-tools \
    resolvconf \
    udisks2 \
    efivar \
    efibootmgr \
    iw \
    sudo \
    gawk \
"
