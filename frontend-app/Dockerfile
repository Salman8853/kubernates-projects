# Stage 1: Build the Angular application
FROM node:18.20.1 AS builder

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json files to the container
COPY package*.json /app/

#RUN npm install -g npm@10.5.1

# Install dependencies
RUN npm install

# Copy the rest of the application source code to the container
COPY . /app/
# Build the Angular application
RUN npm run build
# Stage 2: Setup Nginx server to serve Angular app
# Use NGINX base image for serving Angular application
FROM nginx:alpine
# Copy the build output from the previous stage to NGINX's web root directory
COPY --from=builder /app/dist/frontend-app /usr/share/nginx/html
# Expose port 80 to the outside world
EXPOSE 80
# Command to run NGINX when the container starts
CMD ["nginx", "-g", "daemon off;"]
