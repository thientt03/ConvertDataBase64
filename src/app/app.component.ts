import { Component, OnInit } from '@angular/core';
import { ConvertService } from './convert-service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'project';

  inputData: string = '';
  inputImagetData: any;
  inputRevertData: string = '';
  inputEncodeImageData: string ='';

  convertData: string = '';
  revertData: string = '';
  imageData:any;
  imageEncodeData: any;

  thumbnail: any;

  constructor(
    private convertService: ConvertService,
    private sanitizer: DomSanitizer
  ){
  }

  ngOnInit() {
  }

  postData(str: string) {
    this.convertService.postConvertData(str).subscribe(
      response => {
        // let objectURL = 'data:image/jpeg;base64,' + response;
        // this.thumbnail = this.sanitizer.bypassSecurityTrustUrl(objectURL)
        console.log(response, "aaaaaa");

      },
      error => {
        console.log(error);
      });
  }

  async postRevertData(str: string) {
    this.convertService.postRevertData(str).subscribe(
      response => {
        console.log(response);
        this.revertData = response;
      },
      error => {
        console.log(error);
      });
  }

  async postImageData(file: any) {
    this.convertService.postImageData(file).subscribe(
      response => {
        this.imageData = response;
      },
      error => {
        console.log(error);
      });
  }

  async postEncodeImageData(file: string){
    this.convertService.postEncodeImageData(file).subscribe(
      response => {
        console.log(response);
      },
      error => {
        console.log(error);
      });
  }

  async clickButtonConvert() {
    if(this.inputData){
      await this.postData(this.inputData)
    } else {
      alert("Chua nhap input")
    }
  }

  async clickButtonRevert() {
    if(this.inputRevertData){
      await this.postRevertData(this.inputRevertData)
    } else {
      alert("Chua nhap input")
    }
  }

  async upload(event:any) {
    const file = await  event.target.files[0];
     this.inputImagetData = await file;
    await this.postImageData(this.inputImagetData)
 }

  async clickButtonDecodeImage(){
   if(this.inputEncodeImageData){
    await this.postEncodeImageData(this.inputEncodeImageData)
  } else {
    alert("Chua nhap input")
  }
 }



 async test(){
  if(this.inputEncodeImageData){
   await this.postEncodeImageData(this.inputEncodeImageData)
 } else {
   alert("Chua nhap input")
 }
}


 async testpostEncodeImageData(file: string){
  this.convertService.postImageDataTest(file).subscribe(
    response => {
      console.log(response);
    },
    error => {
      console.log(error);
    });
}
}
