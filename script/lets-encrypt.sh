echo "letsencript renew"
sudo service nginx stop
sudo certbot renew
sudo service nginx start