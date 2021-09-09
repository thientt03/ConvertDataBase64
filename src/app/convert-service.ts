import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}

const httpOptionsImage = {
  headers: new HttpHeaders({'Content-Type': 'multipart/form-data'})
}


@Injectable()
export class ConvertService {
  totalAngularPackages: any;
  errorMessage: any;
  constructor(private httpClient: HttpClient) {
  }

  postConvertData(str: string): Observable<any> {
    let url = 'http://127.0.0.1:8080/encoder';
    return this.httpClient.post(url, JSON.stringify(str), httpOptions)
  }

  postRevertData(str: string): Observable<any> {
    let url = 'http://127.0.0.1:8080/decoder';
    return this.httpClient.post(url, JSON.stringify(str), httpOptions)
  }

  postImageData(file: any): Observable<any> {
    let url = 'http://127.0.0.1:8080/image';
    let formData: any = new FormData();
    formData.append('imageFile', file);
    return this.httpClient.post(url, formData)
  }

  postEncodeImageData(file: string): Observable<any> {
    let url = 'http://127.0.0.1:8080/decode-image';
    return this.httpClient.post(url, JSON.stringify(file), httpOptions)
  }

  postImageDataTest(file: string): Observable<any> {
    let url = 'http://127.0.0.1:8080/test';
    return this.httpClient.post(url, JSON.stringify(file), httpOptions)
  }

}
