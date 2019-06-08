#!/bin/bash

PF="/storage/citadel-state/passwd"
if [ -e "${PF}" ]; then
	exit 0
fi

success=
for ((I = 0; I < 3; I++)); do
	P1=
	P2=
	/usr/bin/plymouth display-message --text='Set new user password...'
	/usr/bin/plymouth pause-progress
	P1="$(/usr/bin/plymouth ask-for-password --prompt='Password')"
	/usr/bin/plymouth unpause-progress
	/usr/bin/plymouth pause-progress
	P2="$(/usr/bin/plymouth ask-for-password --prompt='Confirm')"

	if [ -n "${P1}" -a "${P1}" == "${P2}" ]; then
		/usr/bin/plymouth unpause-progress
		success=true
		break;
	fi
	/usr/bin/plymouth display-message --text='Passwords do not match, try again...'
	/usr/bin/plymouth unpause-progress
	sleep 3
done
if [ -n "${success}" ]; then
	crypt=$(echo -n "${P1}" | /usr/bin/mkpasswd -s -m sha-512)
	echo "citadel:${crypt}" > ${PF}
	chmod 444 "${PF}"
	/usr/bin/plymouth display-message --text='Password set succesfully...'
else
	/usr/bin/plymouth display-message --text='Failed to set password...'
fi
exit 0;
